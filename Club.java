import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Almacena los socios del club
    ArrayList<Membership> socios;

    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        socios = new ArrayList<Membership>();

    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        socios.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return socios.size();
    }

    /** 
     * Calcula el numero de socios que se dieron de alta en un mes determinado. 
     * El año no nos importa. En caso de que el parametro contenga un valor 
     * no valido se muestra por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @return El numero de socios que se dieron de alta dicho mes
     */
    public int joinedMonth(int month)
    {
        int numeroSocios = 0;
        if (month<1 || month >12) //control de rango 
        {
            System.out.println("Has introducido un mes erroneo");
        }
        else
        {
            for(Membership socio : socios) //se recorre la coleccion de socios para comprobar
            // el mes en el que entraron
            {
                if(socio.getMonth() == month) //si el mes introducido por parametro coincide
                //con el mes del socio aumenta numeroSocios
                {
                    numeroSocios++;
                }   
            }
        }
        return numeroSocios;
    }

    /** 
     * Todos los socios que se han dado de alta un determinado mes de un determinado año se
     * dan de baja. En caso de que el parametro month contenga un valor no valido se muestra 
     * por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @param year El año en el que estamos interesados
     * @return Una coleccion con los socios que se han dado de baja del club
     */
    public ArrayList purge(int month,int year)
    {
        ArrayList<Membership> sociosDeBaja = new ArrayList<>();
        if(month<1 || month> 12) //control de rango
        {
            System.out.println("Has introducido un mes erroneo");
            
        }
        else
        {
            Iterator<Membership> it = socios.iterator();
            while(it.hasNext())
            {
                Membership socio = it.next();
                if((socio.getMonth() == month) && (socio.getYear() == year)) //si los parametros coinciden con la fecha de alta de algun socio
                {
                    sociosDeBaja.add(socio);  //se añade el socio que se da de baja a la coleccion sociosDeBaja
                    it.remove();  //se elimina de la coleccion socios
                }
            }
        }
        return sociosDeBaja;
    }
}
