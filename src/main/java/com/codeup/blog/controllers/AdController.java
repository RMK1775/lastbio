package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import com.codeup.blog.models.User;
import com.codeup.blog.repos.AdRepository;
import com.codeup.blog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adDao;
    private final UserRepository userDao;

    public AdController(AdRepository adDao, UserRepository userDao){
        this.adDao = adDao;
        this.userDao = userDao;
    }

    @GetMapping("/ads")
    public String indexAds(Model viewModel){
        viewModel.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/search")
    public String searchAds(@RequestParam(name = "term") String term, Model viewModel){
        term = "%"+term+"%";
        List<Ad> dbAds = adDao.findAllByTitleIsLike(term);
        viewModel.addAttribute("ads", dbAds);
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showAd(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("ad", adDao.getOne(id));
        return "ads/show";
    }
    
    @GetMapping("/ads/create")
    public String showAdCreationForm(){
        return "ads/new";
    }
    
    @PostMapping("/ads/create")
    public String createAd(
            @RequestParam(name = "title") String aTitle,
            @RequestParam(name = "description") String aDesc
    ){
        User user = userDao.getOne(1L);
        Ad newAd = new Ad(aTitle, aDesc, user, null);
        Ad dbAd = adDao.save(newAd);
        return "redirect:/ads/" + dbAd.getId();
    }
    
    @GetMapping("/ads/{id}/edit")
    public String showAdEditForm(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("ad", adDao.getOne(id));
        return "ads/edit";
    }
    
    @PostMapping("/ads/{id}/edit")
    public String editAd(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String desc
    ){
        Ad dbAd = adDao.getOne(id);
        dbAd.setTitle(title);
        dbAd.setDescription(desc);
        adDao.save(dbAd);
        return "redirect:/ads/" + dbAd.getId();
    }
    
    @PostMapping("/ads/{id}/delete")
    public String deleteAd(@PathVariable long id){
        adDao.deleteById(id);
        return "redirect:/ads";
    }


}
