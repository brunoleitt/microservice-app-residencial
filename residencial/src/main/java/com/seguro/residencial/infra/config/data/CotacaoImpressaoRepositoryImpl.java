package com.seguro.residencial.infra.config.data;

import com.seguro.residencial.application.assembler.ObjectMapperUtils;
import com.seguro.residencial.application.models.view.messages.relatorios.cotacoes.CotacaoResource;
import com.seguro.residencial.application.models.view.messages.relatorios.cotacoes.ItemResource;
import com.seguro.residencial.application.models.view.messages.relatorios.cotacoes.SeguradoResource;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoImpressaoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.segurados.SeguradoRoot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

/**
 * @criado 05/12/2020 - 15:11
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
@Getter
@Setter
public class CotacaoImpressaoRepositoryImpl implements ICotacaoImpressaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public CotacaoResource consultarCotacaoImpressao(String codigoCotacao) {
        var cotacaoResouse = consultarCotacao(codigoCotacao);
        cotacaoResouse.setItem(consultarItem(codigoCotacao));
        cotacaoResouse.setSegurado(consultarSegurado(codigoCotacao));
        return cotacaoResouse;
    }

    private ItemResource consultarItem(String codigoCotacao) {

        var builder = manager.getCriteriaBuilder();
        var criteria = builder.createQuery(ItemRoot.class);
        var itemRoot = criteria.from(ItemRoot.class);

        Join<ItemRoot, CotacaoRoot> cotacaoRootJoin = itemRoot.join("cotacao", JoinType.LEFT);
        itemRoot.fetch("cobertura", JoinType.LEFT);
        itemRoot.fetch("enderecoItem", JoinType.LEFT);

        var predicates = new ArrayList<Predicate>();
        predicates.add(builder.equal(cotacaoRootJoin.get("codigoCotacao"), codigoCotacao));

        criteria.select(itemRoot).where(predicates.toArray(new Predicate[0]));
        var query = manager.createQuery(criteria);

        var consulta = query.getResultList();

        var itemResource = ObjectMapperUtils.map(consulta.get(0), ItemResource.class);

        return itemResource;
    }
    private SeguradoResource consultarSegurado(String codigoCotacao) {
        var builder = manager.getCriteriaBuilder();
        var criteria = builder.createQuery(SeguradoRoot.class);
        var seguradoRoot = criteria.from(SeguradoRoot.class);

        Join<SeguradoRoot, CotacaoRoot> cotacaoRootJoin = seguradoRoot.join("cotacao", JoinType.LEFT);

        var predicates = new ArrayList<Predicate>();
        predicates.add(builder.equal(cotacaoRootJoin.get("codigoCotacao"), codigoCotacao));

        criteria.select(seguradoRoot).where(predicates.toArray(new Predicate[0]));
        var query = manager.createQuery(criteria);

        var consulta = query.getResultList();

        var seguradoResource = ObjectMapperUtils.map(consulta.get(0), SeguradoResource.class);

        return seguradoResource;

    }
    private CotacaoResource consultarCotacao(String codigoCotacao) {

        var builder = manager.getCriteriaBuilder();
        var criteria = builder.createQuery(CotacaoRoot.class);
        var cotacaoRoot = criteria.from(CotacaoRoot.class);

        cotacaoRoot.fetch("tipoCalculo", JoinType.LEFT);
        cotacaoRoot.fetch("tipoVigencia", JoinType.LEFT);
        cotacaoRoot.fetch("status", JoinType.LEFT);

        var predicates = new ArrayList<Predicate>();
        predicates.add(builder.equal(cotacaoRoot.get("codigoCotacao"), codigoCotacao));

        criteria.select(cotacaoRoot).where(predicates.toArray(new Predicate[0]));
        var query = manager.createQuery(criteria);

        var consulta = query.getResultList();

        var cotacaoResource = ObjectMapperUtils.map(consulta.get(0), CotacaoResource.class);

        return cotacaoResource;

    }
}
