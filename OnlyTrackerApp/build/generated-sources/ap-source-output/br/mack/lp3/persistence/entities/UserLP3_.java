package br.mack.lp3.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-27T09:52:49")
@StaticMetamodel(UserLP3.class)
public class UserLP3_ { 

    public static volatile SingularAttribute<UserLP3, Date> birthday;
    public static volatile SingularAttribute<UserLP3, String> password;
    public static volatile SingularAttribute<UserLP3, Long> id_userlp3;
    public static volatile SingularAttribute<UserLP3, String> name;
    public static volatile SingularAttribute<UserLP3, String> email;

}