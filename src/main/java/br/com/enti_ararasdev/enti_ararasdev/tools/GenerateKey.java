/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.tools;

/**
 *
 * @author Michel
 */
public class GenerateKey {

    public String generatePass() {
        String pass = "";
        String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        for (int i = 0; i < 10; i++) {
            int j = (int) (Math.random() * carct.length);
            pass += carct[j];
        }
        return pass;
    }
}
