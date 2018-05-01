/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginPackage;

/**
 *
 * @author Martin
 */
public class uniqIDCreator {
   public String createUniqID(){
        int uniqId = (int)(999999*Math.random());
        String id = Integer.toString(uniqId);
        
        return id;
   } 
}
