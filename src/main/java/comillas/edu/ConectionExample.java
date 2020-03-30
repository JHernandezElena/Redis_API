package comillas.edu;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class ConectionExample {

    static public void main(String[] args){
        Jedis jedis = new Jedis("localhost", 6379);
        //Jedis jedis = new Jedis("172.17.0.3", 6379);
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());
        //jedis.configSet("appendonly","yes");

        jedis.set("Clave 1","Valor 1");
        //jedis.h PARA VER TODAS LAS OPCIONES DE HASH
        //jedis.s PARA VER TODAS LAS OCPIONES DEL SET
        System.out.println("Stored string in redis:: "+ jedis.get("Clave 1"));

        Set<String> list = jedis.keys("*");

        for(String s : list){
            System.out.println("List of stored keys:: "+s);
          //  jedis.del(s);
        }
        jedis.close();
    }
}
