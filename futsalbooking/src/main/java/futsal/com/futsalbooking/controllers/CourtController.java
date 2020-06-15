package futsal.com.futsalbooking.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import futsal.com.futsalbooking.models.Court;
//import futsal.com.futsalbooking.repositories.CourtRepository;
import futsal.com.futsalbooking.services.CourtService;


@Controller
public class CourtController {

    @Autowired
    private CourtService courtService;

    //private CourtRepository courtRepository;

    @GetMapping("/courts")
    public String index(Model model) {
      model.addAttribute("courts", courtService.listAll());
        return"index-court";  
    } 


  //add court
  @GetMapping("/addcourt")
      public String showAddForm(Model model) {
       Court court= new Court();
       model.addAttribute("add", true);
       model.addAttribute("courts", court);
        return "add-court";
      }
      @PostMapping("/addcourt")
      public String addCourt(@Valid Court court, BindingResult result, Model model) {
          if (result.hasErrors()) {
              return "add-court";
       }
       //court.setCourtStat("active");  
       courtService.save(court);
       model.addAttribute("add", true);
       model.addAttribute("courts", courtService.listAll());
       return "index-court";
   }

//Update Court by ID
@GetMapping("/{courtID}/edit")
public String showEditCourt ( Model model, @PathVariable("courtID") int id) {
 //Court court= null;
  model.addAttribute("courts", courtService.get(id)); 
  model.addAttribute("add",false);
 // model.addAttribute("courts", court);
  return "edit-court";
}

@PostMapping("/{courtID}/editcourt")
public String updateCourt(@PathVariable("courtID") int id, @Valid Court court, BindingResult result, Model model) {

 // return "redirect:/contacts/" + String.valueOf(court.getCourtID());
 if (result.hasErrors()) {
      return "edit-court";
 }
 court.setCourtID(id);
 courtService.update(court);
model.addAttribute("add", false);
model.addAttribute("courts", courtService.listAll());
return "index-court";
}


   //Delete Court by ID
   @GetMapping("/courtdelete/{courtID}")
   public String showDeleteCourt(@PathVariable("courtID") int id, Model model) {
     model.addAttribute("allowDelete",true);
     //model.addAttribute("courts", courtService.listAll());
     model.addAttribute("courts", courtService.get(id));
     return "delete-court";
      }
    
   @PostMapping("/deletecourt/{courtID}")
   public String deleteCourt(@PathVariable("courtID") int id, Model model) {
    courtService.delete(id);
    model.addAttribute("courts", courtService.listAll());
      return "index-court";
   }
   
  }