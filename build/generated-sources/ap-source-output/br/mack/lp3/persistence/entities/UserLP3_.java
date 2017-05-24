package br.mack.lp3.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-05-24T18:27:42")
@StaticMetamodel(UserLP3.class)
public class UserLP3_ { 

    public static volatile SingularAttribute<UserLP3, Date> birthday;
    public static volatile SingularAttribute<UserLP3, String> password;
    public static volatile SingularAttribute<UserLP3, Long> id_userlp3;
    public static volatile SingularAttribute<UserLP3, String> name;
    public static volatile SingularAttribute<UserLP3, String> email;

}