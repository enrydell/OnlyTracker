package br.mack.lp3.persistence.entities;

import br.mack.lp3.persistence.entities.Movie;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-04T18:45:24")
@StaticMetamodel(UserLP3.class)
public class UserLP3_ { 

    public static volatile CollectionAttribute<UserLP3, Movie> movies;
    public static volatile SingularAttribute<UserLP3, Date> birthday;
    public static volatile SingularAttribute<UserLP3, String> password;
    public static volatile SingularAttribute<UserLP3, Long> id_userlp3;
    public static volatile SingularAttribute<UserLP3, String> name;
    public static volatile SingularAttribute<UserLP3, String> email;

}