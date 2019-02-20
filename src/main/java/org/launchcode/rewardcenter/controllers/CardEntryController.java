package org.launchcode.rewardcenter.controllers;


import jdk.nashorn.internal.ir.RuntimeNode;
import org.launchcode.rewardcenter.models.Card;
import org.launchcode.rewardcenter.models.User;
import org.launchcode.rewardcenter.models.data.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.time.YearMonth;

@Controller
@RequestMapping("card")
public class CardEntryController {

    @Autowired
    private CardDao cardDao;

    @RequestMapping(value = "")
    public String view(Model model) {
        model.addAttribute("title", "Card Data");
        model.addAttribute("cards", cardDao.findAll());
        return "card/view";
    }

    @RequestMapping(value = "addcard", method = RequestMethod.GET)
    public String displayAddcardForm(Model model) {
        model.addAttribute("title", "Card data Entry");
        model.addAttribute(new Card());
        model.addAttribute("cards", cardDao.findAll());
        return "card/addcard";

    }

    @RequestMapping(value = "addcard", method = RequestMethod.POST)
    public String processAddcardForm(@ModelAttribute @Valid Card card, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Card Details");
            model.addAttribute("cards", cardDao.findAll());
            return "card/addcard";
        }
        cardDao.save(card);
        return "redirect:";
    }

    @RequestMapping(value = "delete/{cardId}", method = RequestMethod.GET)
    public String deleteCardRecord(@PathVariable int cardId, Model model) {
        Card card = cardDao.findById(cardId).get();
        cardDao.delete(card);
        model.addAttribute("cards", cardDao.findAll());
        return "card/view";

    }

    @RequestMapping(value = "edit/{cardId}", method = RequestMethod.GET)
    public String diasplayEditForm( @PathVariable int cardId,Model model) {
        model.addAttribute("title", " Update the info");
        model.addAttribute("card",cardDao.findById(cardId));
        model.addAttribute("cards", cardDao.findAll());
        return "card/edit";
    }

    @RequestMapping(value="edit",method = RequestMethod.POST)
    public String processEditForm(@RequestParam int cardId, @RequestParam String cardName, @RequestParam String cardBrand,
                                  @RequestParam BigInteger cardNumber, @RequestParam String cardType,
                                  @RequestParam String issuedBank, @RequestParam YearMonth yearMonth){

        Card card =cardDao.findById(cardId).get();
        card.setCardName(cardName);
        card.setCardBrand(cardBrand);
        card.setCardNumber(cardNumber);
        card.setCardType(cardType);
        card.setIssuedBank(issuedBank);
        card.setYearMonth(yearMonth);

        cardDao.save(card);
        return "redirect:";

    }
}