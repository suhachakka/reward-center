package org.launchcode.rewardcenter.controllers;

import org.launchcode.rewardcenter.models.Card;
import org.launchcode.rewardcenter.models.Category;
import org.launchcode.rewardcenter.models.Department;
import org.launchcode.rewardcenter.models.Offer;
import org.launchcode.rewardcenter.models.data.CardDao;
import org.launchcode.rewardcenter.models.data.CategoryDao;
import org.launchcode.rewardcenter.models.data.DepartmentDao;
import org.launchcode.rewardcenter.models.data.OfferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.stream.Collectors;

@Controller
@RequestMapping("offer")
public class OfferController {

    @Autowired
    private OfferDao offerDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private CardDao cardDao;

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "")
    public String index(Model model,
                        @RequestParam(defaultValue="0") int page) {
        model.addAttribute("title", "Offers");
//        model.addAttribute("offer",offerDao.findAll(new PageRequest(page,4)));
//        model.addAttribute("currentPage",page);
        model.addAttribute("offers", offerDao.findAll());

        return "offer/view";
    }


    @RequestMapping(value = "addoffer", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Offers");
        model.addAttribute(new Offer());
        model.addAttribute("offers", offerDao.findAll());
        model.addAttribute("departments", departmentDao.findAll());
        model.addAttribute("cards", cardDao.findAll());
        model.addAttribute("categories", categoryDao.findAll());
        return "offer/addoffer";
    }

    @RequestMapping(value = "addoffer", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Offer offer, Errors errors,
                                       @RequestParam int deptId,
                                       @RequestParam int cardId,
                                       @RequestParam int categoryId,
                                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("departments", departmentDao.findAll());
            model.addAttribute("cards", cardDao.findAll());
            model.addAttribute("categories", categoryDao.findAll());
            model.addAttribute("offers", offerDao.findAll());

            return "offer/addoffer";
        }
        model.addAttribute("offer",offer);
        Department department = departmentDao.findById(deptId).get();
        offer.setDepartment(department);

        Card card = cardDao.findById(cardId).get();
        offer.setCard(card);
        offerDao.save(offer);

        Category category = categoryDao.findById(categoryId).get();
        offer.setCategory(category);
        offerDao.save(offer);


        return "redirect:";
    }

    @RequestMapping(value = "delete/{offerId}", method = RequestMethod.GET)
    public String displayRemoveOfferForm(Model model, @PathVariable int offerId) {
        Offer offer = offerDao.findById(offerId).get();
        offerDao.delete(offer);
        model.addAttribute("offers", offerDao.findAll());
        return "offer/view";
    }


    @RequestMapping(value = "edit/{offerId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int offerId) {
        model.addAttribute("offer", offerDao.findById(offerId));
        model.addAttribute("offers",offerDao.findAll());
        model.addAttribute("cards",cardDao.findAll());
        model.addAttribute("departments",departmentDao.findAll());

       model.addAttribute("categories", categoryDao.findAll());

        return "offer/edit";

    }


    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@RequestParam int offerId, @RequestParam double qualified_amt,
                                  @RequestParam(defaultValue = "none") double cashBack, @RequestParam String ExpiryDate,
                                  @RequestParam String CouponCode, @RequestParam String cashMode,
                                  @RequestParam int categoryId,@RequestParam int deptId,@RequestParam int cardId) throws ParseException {

        Offer offer = offerDao.findById(offerId).get();
        Category category = categoryDao.findById(categoryId).get();
        Department department =departmentDao.findById(deptId).get();
        Card card =cardDao.findById(cardId).get();
        offer.setQualified_amt(qualified_amt);
        offer.setExpiryDate(ExpiryDate);
        offer.setCashMode(cashMode);
        offer.setCouponCode(CouponCode);
        offer.setCashBack(cashBack);
        offer.setDepartment(department);
        offer.setCategory(category);
        offer.setCard(card);
        offerDao.save(offer);

        return "redirect:";
    }

//    @InitBinder
//    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
//        super.initBinder(request, binder);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //yyyy-MM-dd'T'HH:mm:ssZ example
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); //Trim strings
//        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma z");
//    }
}

