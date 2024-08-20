package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Autowired
    private GuestRepo gr;

    @GetMapping
    public Page<Guest> getAllGuests(Pageable pageable)
    {
        return gr.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        return gr.findById(id).orElseThrow() ;
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return gr.save(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest updatedGuest) 
    {
        Guest g = gr.findById(id).orElseThrow();
        g.setName(updatedGuest.getName());
        g.setEmail(updatedGuest.getEmail());
        g.setCheckin(updatedGuest.getCheckin());
        return gr.save(g);
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id) {
        gr.deleteById(id);
    }

    @GetMapping("/sort")
    public List<Guest> getAllSorted(@RequestParam String sortBy) {
        return gr.findAll(Sort.by(sortBy));
    }
}
