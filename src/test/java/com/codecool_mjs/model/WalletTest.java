package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    private Wallet wallet;

    @BeforeEach
    void setup() {

        this.wallet = new Wallet(2, 1000, 1000);
    }

    @Test
    void testCreatingEmptyWallet() {

        Wallet wallet = new Wallet();
        Integer id = wallet.getId();

        assertNull(id, "Constructor sets fields to incorrect values.");
    }

    @Test
    void testSettingAndGettingID() {

        int testID = 3;
        wallet.setId(testID);
        int id = wallet.getId();

        assertEquals(testID, id,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSettingAndGettingAvailableCoins() {

        int testCoins = 2000;

        wallet.setAvailableCoins(testCoins);
        int coins = wallet.getAvailableCoins();

        assertEquals(testCoins, coins,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSettingAndGettingTotalEarnedCoins() {

        int testCoins = 2500;

        wallet.setTotalEarnedCoins(testCoins);
        int coins = wallet.getTotalEarnedCoins();

        assertEquals(testCoins, coins,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testAddingCoins() {

        int testCoins = 200;

        wallet.addCoins(testCoins);
        int coinsEarned = wallet.getTotalEarnedCoins();
        int coinsAvailable = wallet.getAvailableCoins();

        assertEquals(coinsAvailable, coinsEarned,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testRemovingCoins() {

        int testCoins = 2000;
        int testRemoved = 200;

        wallet.setAvailableCoins(testCoins);
        wallet.removeCoins(testRemoved);
        int coins = wallet.getAvailableCoins();

        assertEquals(testCoins - testRemoved, coins,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testRemovingCoinsNegativeBalance() {

        int testCoins = 2000;

        wallet.setAvailableCoins(testCoins);
        assertThrows(IllegalArgumentException.class, () -> wallet.removeCoins(testCoins + 1),
                "Too much coins can be removed. Value < 0.");
    }

    @Test
    void testSettingNegativeAvailableBalance() {

        int testCoins = -100;

        assertThrows(IllegalArgumentException.class, () ->  wallet.setAvailableCoins(testCoins),
                "Available balance can be set to a negative value.");
    }

    @Test
    void testSettingNegativeTotalBalance() {

        int testCoins = -100;

        assertThrows(IllegalArgumentException.class, () ->  wallet.setTotalEarnedCoins(testCoins),
                "Total balance can be set to a negative value.");
    }
}