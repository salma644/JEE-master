package com.charge.charge.controllers;

import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import com.charge.charge.entities.Famille;
import com.charge.charge.services.ChargeService;
import com.charge.charge.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.charge.charge.entities.Charge;

import java.util.List;


@Controller
public class ChargeController {
    @Autowired
    ChargeService chargeService;
    @Autowired
    FamilleService familleService;

    @RequestMapping("/createCharge")
    public String createCharge(Model model) {
        List<Famille> familleList = familleService.getAllFamilles();
        model.addAttribute("familleList", familleList);
        model.addAttribute("charge", new Charge());
        return "CreateCharge";
    }

    @RequestMapping("/saveCharge")
    public String saveCharge(@ModelAttribute("chargethym") Charge charge, @RequestParam("familleId") int familleId) throws ChangeSetPersister.NotFoundException {

        Famille famille = familleService.getFamilleById(familleId);
        charge.setFamille(famille);
        Charge memo = chargeService.saveCharge(charge);
        return "CreateCharge";
    }

    @RequestMapping("/chargesList")
    public String chargesList(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        Page<Charge> chargesController = chargeService.getAllChargesByPage(page, size);
        model.addAttribute("chargethym", chargesController);
        model.addAttribute("pages", new int[chargesController.getTotalPages()]);
        model.addAttribute("currentPage", page);
//modelMap.addAttribute(attributeName: "productsJspl", productsController);
        return "ChargesList";
    }

    @RequestMapping("/deleteCharge")
    public String deleteProduct(@RequestParam("id") int id, Model model,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size


    ) {
        chargeService.deleteCharge(id);
        Page<Charge> chargesController = chargeService.getAllChargesByPage(page, size);
        model.addAttribute("chargethym", chargesController);
        model.addAttribute("pages", new int[chargesController.getTotalPages()]);
        model.addAttribute("currentPage", page);
//modelMap.addAttribute(attributeName: "productsJspl", productsController);
        return "ChargesList";
    }

    @RequestMapping("/showCharge")
    public String showCharge(@RequestParam("id") int id, ModelMap model) throws ChangeSetPersister.NotFoundException {
        Charge charge = chargeService.getChargeById(id);
        model.addAttribute("chargethym", charge);
        return "EditCharge";
    }

    @RequestMapping("/updateCharge")
    public String updateCharge(@ModelAttribute("chargethym") Charge charge) {
        chargeService.updateCharge(charge);
        return "redirect:/chargesList";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/chargesList";
    }
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
