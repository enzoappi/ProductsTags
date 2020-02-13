/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.UsedProduct;
import entities.ImportedProduct;
import java.text.ParseException;


/**
 *
 * @author ut2u
 */
public class Program {
    
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Product> list = new ArrayList<>();
        
        System.out.print("Insert the number of product(s) that should be add: ");
        int n = sc.nextInt();
        
        for(int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + ":");
            System.out.print("Type of product [Common (c), used (u) or imported (i)]: ");
            char opt = sc.next().charAt(0);
            System.out.print("Product Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Product Price: ");
            double price = sc.nextDouble();
            
            if(opt == 'c'){
                list.add(new Product(name, price));
            }
            else if (opt == 'u'){
                System.out.print("Insert the product's Manufature Date [dd/MM/yyyy]: ");
                Date date = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, date));
            }
            else{
                System.out.print("Insert the product's Customs fee: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
        }
        
        System.out.println();
	System.out.println("PRICE TAGS:");
	for (Product prod : list) {
            System.out.println(prod.priceTag());
        }
        
        
        sc.close();
    }
}
