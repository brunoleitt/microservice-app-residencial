package com.seguros.relatorio.application.assembler;

import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @criado 17/11/2020 - 20:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@NoArgsConstructor
public class ObjectMapperUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    /***
     * A configuração da propriedade do Mapper é especificada no bloco a seguir.
     * A estratégia de envio da propriedade padrão é definida como Strict, consulte
     * Mapeamentos personalizados são adicionados usando addMappings
      */
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /***
     * <p> Observação: o objeto outClass deve ter um construtor padrão sem argumentos "@NoArgsConstructor" </p>
     * @param <D> 		tipo de objeto de resultado.
     * @param <T> 		tipo de objeto de origem a partir do qual mapear.
     * @param entity    entidade @param que precisa ser mapeada.
     * @param outClass  classe do objeto de resultado.
     * @return novo objeto do tipo <code>outClass</code>.
     */
    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }


    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }

}
