package com.banking.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.model.SavingsTransfers;
import com.banking.model.User;
import com.banking.model.SavingsAccount;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsAccountService;
import com.banking.servcie.SavingsTransactionService;
import com.banking.servcie.SavingsTransfersService;

@Controller
public class SavingsAccountController {
	
	@Autowired
	private SavingsTransfersService transfersService;
	
	@Autowired
	private RegisterService registerService;
	
    @Autowired
    private SavingsTransactionService transactionService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
//	@PostMapping("/savingsAccount")
//	public SavingsAccount createSavingsAccount() {
//		return savingsAccountService.createSavingsAccount();
//	}
	
	@GetMapping("/savingsAccount/accountBalance")
	public String getSavingsAccountBalance(@RequestParam("username") String username) {
		User user= registerService.findByUsername(username);
		int savingsAccountId = user.getSavingsAccount().getSavingsAccountId();
		System.out.println(savingsAccountId);
		String bal=savingsAccountService.getSavingsAccountBalance(savingsAccountId);
		System.out.println(bal);
		return bal;
	}
	
    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String deposit(Model model) {
//        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositPOST(@ModelAttribute("amount") String amount, @ModelAttribute("username") String username) {
    	savingsAccountService.deposit(Double.parseDouble(amount), username);

        return "redirect:/userFront";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
//        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawPOST(@ModelAttribute("amount") String amount, @ModelAttribute("username") String username) {
    	savingsAccountService.withdraw(Double.parseDouble(amount), username);

        return "redirect:/userFront";
    
    }
}
