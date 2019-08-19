/*
 * Author: Tristan GUENEAU
 * This class is a command redirecting to the appropriate page when
 * the user is scrolling on some page
 */


package commands;

import pages.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static steps.TestBase.driver;


public class CreateScrollCommand {


    private final Map<String, CommandScroll> DESTINATIONS;
    private HomePage homePage = new HomePage(driver);
    private EditData editData = new EditData(driver);
    private Transactions transactions = new Transactions(driver);
    private CompleteProfile completeProfile = new CompleteProfile(driver);
    private Information information = new Information(driver);
    /**
     * Each button name is linked with a specific command
     */

    {
        final Map<String, CommandScroll> destinations = new HashMap<String, CommandScroll>();

        destinations.put("Side Menu", new CommandScroll() {
            @Override
            public void scroll() {
                homePage.scrollMenu();
            }
        });
        destinations.put("Edit Data", new CommandScroll() {
            @Override
            public void scroll() {
                editData.scrollMenu();
            }
        });
        destinations.put("Transactions", new CommandScroll() {
            @Override
            public void scroll() {
                transactions.scrollMenu();
            }
        });
        destinations.put("Profile", new CommandScroll() {
            @Override
            public void scroll() {
                completeProfile.scrollMenu();
            }
        });
        destinations.put("Provider", new CommandScroll() {
            @Override
            public void scroll() {
                information.scrollMenu();
            }
        });

        DESTINATIONS = Collections.unmodifiableMap(destinations);
    }

    public void scrollPage(String pageName) throws InterruptedException {
        CommandScroll command = DESTINATIONS.get(pageName);
        if(command == null) {
            throw new IllegalArgumentException("Invalid page name : " + pageName);
        }
        command.scroll();
    }
































}
