package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-24T05:43:36")
@StaticMetamodel(CategoriaUsuario.class)
public class CategoriaUsuario_ { 

    public static volatile SingularAttribute<CategoriaUsuario, Long> codCatUser;
    public static volatile SingularAttribute<CategoriaUsuario, String> descricao;
    public static volatile SingularAttribute<CategoriaUsuario, String> prioridade;
    public static volatile ListAttribute<CategoriaUsuario, Usuario> usuarios;

}