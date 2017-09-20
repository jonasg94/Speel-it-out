/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spell_it_out;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author joaogomes
 */
public class Number {
    
    int number;
    //Pequenos numeros até ao 19
    
    List <String> small_numbers;
    List <String> tens_numbers;
    List <String> scale_numbers;
    List <String> number_spell = new ArrayList<>();
    public Number(int number){
        small_numbers = Arrays.asList("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen");
        tens_numbers = Arrays.asList( "Ten", "Twenty", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety");
        scale_numbers = Arrays.asList("", "Thousand", "Million", "Billion");
        number_spell.add(" ");
        this.number = number;
        
    }
    
    public List<String> spell(){
         // Zero rule
        if (number == 0)
        {
             number_spell.add(small_numbers.get(0));
        }
        
        // Array que permite guardar 4 grupos de digitos
        List<Integer> digitos = new ArrayList<>();
 
        //Obrigamos o numero a ser positivo
        int positivo = Math.abs(number);
         
        for(int i = 0; i < 4 ; i ++){
            digitos.add(positivo % 1000);
            positivo /= 1000;
        }
        
 
        for (int i = 3; i >= 0; i--)
        {
            if(digitos.get(i) != 0 && i == 3){
                number_spell.add(scale_numbers.get(i) + " and ");
                break;
            }
            if(digitos.get(i) !=0){
                int centenas = digitos.get(i)/100;
                int dezenas_unidades = digitos.get(i)%100;
                int dezenas = dezenas_unidades/10;
                int unidades= dezenas_unidades%10;
                if(centenas> 0){
                    number_spell.add(small_numbers.get(centenas) + " hundread " );
                }
                if(dezenas> 0 ){
                    number_spell.add(tens_numbers.get(dezenas) + " ");
                }
                if(unidades> 0){
                    number_spell.add(small_numbers.get(unidades) + " ");
                
                }
              number_spell.add(scale_numbers.get(i) + " " );
              if(i!=0){
                  number_spell.add("and ");
              }
              
            }
            
        }


            return number_spell;
    }
}
