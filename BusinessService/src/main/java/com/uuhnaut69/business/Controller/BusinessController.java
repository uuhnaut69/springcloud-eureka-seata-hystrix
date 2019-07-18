package com.uuhnaut69.business.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.business.Service.BusinessService;

@RestController
public  class  BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * Purchase order, simulate global transaction submission
     *
     * @return
     */
    @RequestMapping("/purchase/commit")
    public Boolean purchaseCommit() {
        businessService.purchase("1001", "2001", 1);
        return true;
    }

    /**
     * Purchase order, simulate global transaction rollback
     *
     * @return
     */
    @RequestMapping("/purchase/rollback")
    public Boolean purchaseRollback() {
        try {
            businessService.purchase("1002", "2001", 1);
        } catch (Exception e) {
            e . printStackTrace ();
            return false;
        }

        return true;
    }
}