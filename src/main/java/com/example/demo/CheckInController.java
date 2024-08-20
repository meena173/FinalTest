package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkin")
public class CheckInController 
{

    @Autowired
    private CheckInRepo cr;

    @GetMapping
    public Page<CheckIn> getAllCheckIns(Pageable pageable) 
    {
        return cr.findAll(pageable);
    }

    @GetMapping("/{id}")
    public CheckIn getCheckInById(@PathVariable Long id) 
    {
        return cr.findById(id).orElse(null);
    }

    @PostMapping
    public CheckIn createCheckIn(@RequestBody CheckIn checkIn)
    {
       
        for (Guest guest : checkIn.getGuests()) 
        {
            guest.setCheckin(checkIn);
        }
        return cr.save(checkIn);
    }

    @PutMapping("/{id}")
    public CheckIn updateCheckIn(@PathVariable Long id, @RequestBody CheckIn updatedCheckIn)
    {
        CheckIn cn = cr.findById(id).orElseThrow();
        cn.setGuests(updatedCheckIn.getGuests());

        for (Guest guest : cn.getGuests()) 
        {
            guest.setCheckin(cn);
        }
        
        return cr.save(cn);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        cr.deleteById(id);
    }

    @GetMapping("/sort")
    public List<CheckIn> getAllSorted(@RequestParam String sortBy) 
    {
        return cr.findAll(Sort.by(sortBy));
    }
}
