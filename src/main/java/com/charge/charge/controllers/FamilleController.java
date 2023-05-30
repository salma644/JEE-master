package com.charge.charge.controllers;

import com.charge.charge.entities.Charge;
import com.charge.charge.entities.Famille;
import com.charge.charge.services.ChargeService;
import com.charge.charge.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class FamilleController {
    @Autowired
    ChargeService chargeService;
    @Autowired
    FamilleService familleService;

    @RequestMapping("/createFamille")
    public String createCharge(Model model) {

        model.addAttribute("famille", new Famille());
        return "CreateFamille";
    }

    @RequestMapping("/saveFamille")
    public String saveCharge(@ModelAttribute("famillethym") Famille famille) throws ChangeSetPersister.NotFoundException {

        Famille memo = familleService.saveFamille(famille);
        return "CreateFamille";
    }

    @RequestMapping("/famillesList")
    public String famillesList(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        Page<Famille> famillesController = familleService.getAllFamillesByPage(page, size);
        model.addAttribute("famillethym", famillesController);
        model.addAttribute("pages", new int[famillesController.getTotalPages()]);
        model.addAttribute("currentPage", page);
//modelMap.addAttribute(attributeName: "productsJspl", productsController);
        return "famillesList";
    }

    @RequestMapping("/deleteFamille")
    public String deletefamille(@RequestParam("id") int id, Model model,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size


    ) {
        familleService.deleteFamille(id);
        Page<Famille> famillesController = familleService.getAllFamillesByPage(page, size);
        model.addAttribute("famillethym", famillesController);
        model.addAttribute("pages", new int[famillesController.getTotalPages()]);
        model.addAttribute("currentPage", page);
//modelMap.addAttribute(attributeName: "productsJspl", productsController);
        return "FamillesList";
    }

    @RequestMapping("/showFamille")
    public String showCharge(@RequestParam("id") int id, ModelMap model) throws ChangeSetPersister.NotFoundException {
        Famille famille = familleService.getFamilleById(id);
        model.addAttribute("famillethym", famille);
        return "EditFamille";
    }

    @RequestMapping("/updateFamille")
    public String updateFamille(@ModelAttribute("famillethym") Famille famille) {
        familleService.updateFamille(famille);
        return "redirect:/famillesList";
    }


}
