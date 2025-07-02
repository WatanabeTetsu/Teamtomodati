package jp.te4a.spring.boot.myapp13.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp13.form.FacilityForm;
import jp.te4a.spring.boot.myapp13.service.FacilityService;

@Controller
@RequestMapping("facilities")
public class FacilityController {
    @Autowired
    FacilityService facilityService;
    @ModelAttribute
    FacilityForm setUpForm() {
        return new FacilityForm();
    }
    @GetMapping
    String list(Model model) {
        model.addAttribute("facilities", facilityService.findAll());
        return "facilities/list";
    }
    @PostMapping(path="create")
    String create(@Validated FacilityForm form,BindingResult result, Model model) {
        if(result.hasErrors()) {
            return list(model);
        }
        facilityService.create(form);
        return "redirect:/facilities";
    }
    @PostMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id,FacilityForm form) {
        FacilityForm facilityForm = facilityService.findOne(id);
        BeanUtils.copyProperties(facilityForm, form);
        return "facilities/edit";
    }
    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id,@Validated FacilityForm form,BindingResult result) {
        if(result.hasErrors()) {
            return editForm(id,form);
        }
        facilityService.update(form);
        return "redirect:/facilities";
    }
    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        facilityService.delete(id);
        return "redirect:/facilities";
    }
    @PostMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/facilities";
    }
}