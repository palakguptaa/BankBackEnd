package com.banking.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsTransfersService;

@Controller
public class SavingsTransfersController {

	@Autowired
	private SavingsTransfersService savingsTransferService; 
	
	@Autowired
	private RegisterService registerService;

//	@PostMapping("/tranfers")
//	public void totransferToOtherUser(@RequestParam("recipientAccountNumber")long receiverAccountNumber,@RequestParam("amount") String amount, @RequestParam("recipient")String recipient,Principal principal) {
//		
//		savingsTransferService.toSomeoneElseTransfer(receiverAccountNumber, amount, recipient, principal);
//		
//	}
	
//    @RequestMapping(value = "/toSomeoneElse",method = RequestMethod.GET)
//    public String toSomeoneElse(Model model, Principal principal) {
//        
//        model.addAttribute("recipientAccountNumber", "");
//        model.addAttribute("recipient", "");
//
//        return "toSomeoneElse";
//    }
	
	@RequestMapping(value = "/toSomeoneElse",method = RequestMethod.POST)
    public String toSomeoneElsePost(@ModelAttribute("recipientAccountNumber") long receiverAccountNumber, @ModelAttribute("amount") String amount,@ModelAttribute("recipient") String recipient,@ModelAttribute("username") String username) {
        User user = registerService.findByUsername(username);
        int savingsAccountId = user.getSavingsAccount().getSavingsAccountId();
        
        savingsTransferService.toSomeoneElseTransfer(receiverAccountNumber, amount, recipient,savingsAccountId);

        return "redirect:/ICINBank";
    }

}
