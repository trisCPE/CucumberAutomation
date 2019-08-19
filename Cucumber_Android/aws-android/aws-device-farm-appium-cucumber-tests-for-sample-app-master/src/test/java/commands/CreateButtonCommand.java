/*
 * Author: Tristan GUENEAU
 * This class is a command redirecting to the appropriate page when
 * a button is pressed by the user.
 */

package commands;


import pages.*;
import pages.PaymentMethods.CashIn;
import pages.PaymentMethods.DirectPay;
import pages.PaymentMethods.Pay;
import pages.PaymentMethods.TopUp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static steps.TestBase.driver;

//Invoker to process any commands
public class CreateButtonCommand {

    private final Map<String, CommandButton> BUTTONS;
    private HomePage homePage = new HomePage(driver);
    private BanksAndCards banksAndCards = new BanksAndCards(driver);
    private Security security = new Security(driver);
    private Transactions transactions = new Transactions(driver);
    private DirectPay directPay = new DirectPay(driver);
    private Pay pay = new Pay(driver);
    private Withdrawal withdrawal = new Withdrawal(driver);
    private CompleteProfile completeProfile = new CompleteProfile(driver);
    private EditData editData = new EditData(driver);
    private CashIn cashIn = new CashIn(driver);
    private TopUp topUp = new TopUp(driver);

    /**
     * Each button name is linked with a specific command
     */
    {
        final Map<String, CommandButton> buttons = new HashMap<String, CommandButton>();
        buttons.put("Side Menu", new CommandButton() {
            @Override
            public void press(){
                homePage.pressSideButton();
            }
        });
        buttons.put("Information", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Information");
            }
        });
        buttons.put("Banks & cards", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Banks & cards");
            }
        });
        buttons.put("Transactions", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Transactions");
            }
        });
        buttons.put("Vouchers", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Vouchers");
            }
        });

        buttons.put("Security", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Security");
            }
        });

        buttons.put("Withdrawal", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Withdrawal");
            }
        });

        buttons.put("About Mercedes pay", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("About Mercedes pay");
            }
        });

        buttons.put("App permissions", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("App permissions");
            }
        });

        buttons.put("Customer Support", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Customer Support");
            }
        });

        buttons.put("FAQs", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("FAQs");
            }
        });

        buttons.put("Cookies Policy", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Cookies Policy");
            }
        });
        buttons.put("General Terms & Conditions", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("General Terms & Conditions");
            }
        });
        buttons.put("Privacy Statement", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Privacy Statement");
            }
        });
        buttons.put("Logout", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Logout");
            }
        });
        buttons.put("Overview", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Overview");
            }
        });
        buttons.put("Paid", new CommandButton() {
            @Override
            public void press() {
                transactions.pressButton("Paid");
            }
        });
        buttons.put("Received", new CommandButton() {
            @Override
            public void press() {
                transactions.pressButton("Received");
            }
        });
        buttons.put("Edit personal data", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Edit personal data");
            }
        });
        buttons.put("Anonymous", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Anonymous");
            }
        });
        buttons.put("Reserved", new CommandButton() {
            @Override
            public void press() {
                transactions.pressButton("Reserved");
            }
        });

        buttons.put("Change password", new CommandButton() {
            @Override
            public void press() {
                security.pressButton("Change password");
            }
        });

        buttons.put("Clear cookies", new CommandButton() {
            @Override
            public void press() {
                security.pressButton("Clear cookies");
            }
        });
        buttons.put("No", new CommandButton() {
            @Override
            public void press() {
                if (security.getSecurityHeader().isDisplayed())
                    security.pressButton("No");
                else
                    cashIn.pressButton("No");
            }
        });
        buttons.put("Fab", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Fab");
            }
        });
        buttons.put("Direct Pay", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Direct Pay");
            }
        });
        buttons.put("CANCEL", new CommandButton() {
            @Override
            public void press() {
                directPay.pressButton("CANCEL");
            }
        });
        buttons.put("CONTINUE", new CommandButton() {
            @Override
            public void press() {
                pay.pressButton("CONTINUE");
            }
        });

        buttons.put("Add comment", new CommandButton() {
            @Override
            public void press() {
                pay.pressButton("Add comment");
            }
        });
        buttons.put("Close button", new CommandButton() {
            @Override
            public void press() {
                pay.pressButton("Close button");
            }
        });
        buttons.put("QR Code", new CommandButton() {
            @Override
            public void press() {
                pay.pressButton("QR Code");
            }
        });
        buttons.put("Save", new CommandButton() {
            @Override
            public void press() {
                pay.pressButton("Save");
            }
        });
        buttons.put("Pay", new CommandButton() {
            @Override
            public void press() {
                pay.pressButton("Pay");
            }
        });
        buttons.put("Remove comment", new CommandButton() {
            @Override
            public void press() {
                pay.pressButton("Remove comment");
            }
        });
        buttons.put("FabPay", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("FabPay");
            }
        });
        buttons.put("Top Up", new CommandButton() {@Override
        public void press() {
                homePage.pressButton("Top Up");
            }
        });
        buttons.put("Send Money", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Send Money");
            }
        });
        buttons.put("Cash In", new CommandButton() {
            @Override
            public void press() {
                homePage.pressButton("Cash In");
            }
        });
        buttons.put("Ok", new CommandButton() {
            @Override
            public void press() {
                try{
                    driver.findElementByAndroidUIAutomator("new UiSelector().textMatches(\"Withdrawal\")");
                    withdrawal.pressButton("Ok");
                } catch(Exception e){
                    topUp.pressButton("Ok");
                }
            }
        });
        buttons.put("Later", new CommandButton() {
            @Override
            public void press() {
                completeProfile.pressButton("Later");
            }
        });
        buttons.put("Ends with", new CommandButton() {
            @Override
            public void press() {
                withdrawal.pressButton("Ends with");
            }
        });
        buttons.put("Add", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Add");
            }
        });

        buttons.put("BANK ACCOUNT", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("BANK ACCOUNT");
            }
        });

        buttons.put("CREDIT CARD", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("CREDIT CARD");
            }

        });

        buttons.put("Cancel", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Cancel");
            }
        });
        buttons.put("Delete", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Delete");
            }
        });
        buttons.put("Enter your verification code", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Enter your verification code");
            }
        });
        buttons.put("Finish", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Finish");
            }
        });
        buttons.put("BELFIUS BANK",
                new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("BELFIUS BANK");
            }
        });
        buttons.put("Fortuna Banque s.c.",
                new CommandButton() {
                    @Override
                    public void press() {
                        banksAndCards.pressButton("Fortuna Banque s.c.");
                    }
                });
        buttons.put("SEPA DD Mandate", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("SEPA DD Mandate");
            }
        });
        buttons.put("DELETE", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("DELETE");
            }
        });
        buttons.put("Next", new CommandButton() {
            @Override
            public void press() {
                try{
                    banksAndCards.getBtnAddItem().isDisplayed(); /*If we are on Banks & Cards*/
                    banksAndCards.pressButton("Next");
                }catch(Exception e){
                    withdrawal.pressButton("Next");
                }
            }
        });
        buttons.put("EditSave", new CommandButton() {
            @Override
            public void press() {
                editData.pressButton("EditSave");
            }
        });
        buttons.put("Name", new CommandButton() {
            @Override
            public void press() {
                editData.pressButton("Name");
            }
        });
        buttons.put("Close account", new CommandButton() {
            @Override
            public void press() {
                editData.pressButton("Close account");
            }
        });
        buttons.put("Cancel_Edit", new CommandButton() {
            @Override
            public void press() {
                editData.pressButton("Cancel_Edit");
            }
        });
        buttons.put("Accepted countries", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Accepted countries");
            }
        });
        buttons.put("Flashlight", new CommandButton() {
            @Override
            public void press() {
                cashIn.pressButton("Flashlight");
            }
        });
        buttons.put("Allow", new CommandButton() {
            @Override
            public void press() {
                cashIn.pressButton("Allow");
            }
        });
        buttons.put("Deny", new CommandButton() {
            @Override
            public void press() {
                cashIn.pressButton("Deny");
            }
        });
        buttons.put("Yes", new CommandButton() {
            @Override
            public void press() {
                cashIn.pressButton("Yes");
            }
        });
        buttons.put("Add bank account", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Add bank account");
            }
        });
        buttons.put("Payment method", new CommandButton() {
            @Override
            public void press() {
                banksAndCards.pressButton("Payment method");
            }
        });

        BUTTONS = Collections.unmodifiableMap(buttons);
    }

    /**
     * Determine which command should be executed depending on the button type.
     * @param buttonType
     * @throws InterruptedException
     */
    public void pressButton(String buttonType) throws InterruptedException {
        CommandButton command = BUTTONS.get(buttonType);
        if(command == null) {
            throw new IllegalArgumentException("Invalid button type: " + buttonType);
        }
        command.press();//executes the specific command
    }
}