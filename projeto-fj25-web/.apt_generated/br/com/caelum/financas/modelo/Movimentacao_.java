package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Movimentacao.class)
public abstract class Movimentacao_ {

	public static volatile ListAttribute<Movimentacao, Tag> tags;
	public static volatile SingularAttribute<Movimentacao, Integer> id;
	public static volatile SingularAttribute<Movimentacao, BigDecimal> valor;
	public static volatile SingularAttribute<Movimentacao, Calendar> data;
	public static volatile SingularAttribute<Movimentacao, Conta> conta;
	public static volatile SingularAttribute<Movimentacao, TipoMovimentacao> tipoMovimentacao;
	public static volatile SingularAttribute<Movimentacao, String> descricao;

}

