/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ahmet
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        islem();
    }
    public static void islem() throws UnknownHostException, IOException {
          Socket socket = null;
          PrintWriter out = null;
          BufferedReader in = null;
          String deger;
          try {
               //* server 'a localhost ve 7755 portu üzerinden başlantı sağlanıyor *//
               socket = new Socket("localhost", 7755);
          } catch (Exception e) {
               System.out.println("Port Hatası!");
          }
           //* Server'a veri gönderimi için kullandığımız PrintWriter nesnesi oluşturduk *//
          out = new PrintWriter(socket.getOutputStream(), true);
 
          //* Server'dan gelen verileri tutan BufferedReader nesnesi oluşturulur *//
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
          System.out.println("Server'a gönderilecek sayısı giriniz:");
 
          //* Gönderilecek sayının girişi yapılıyor *//
          BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
 
          while((deger = data.readLine()) != null) {
               out.println(deger);
               System.out.println("Server'dan gelen sonuç = " + in.readLine());
               System.out.println("Server'a gönderilecek saysı giriniz");
          }
          out.close();
          in.close();
          data.close();
          socket.close();
     }
    
}
