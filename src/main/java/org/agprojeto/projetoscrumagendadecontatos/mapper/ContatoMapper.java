package org.agprojeto.projetoscrumagendadecontatos.mapper;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.model.entities.Contato;
import org.modelmapper.ModelMapper;

public class ContatoMapper {

    private static final ModelMapper modelMapper = new ModelMapper();


    public static ContatoDTO toDTO(Contato contato) {
        if (contato == null) {
            return null;
        }
        return modelMapper.map(contato, ContatoDTO.class);
    }

    public static Contato toEntity(ContatoDTO contatoDTO) {
        if (contatoDTO == null) {
            return null;
        }
        return modelMapper.map(contatoDTO, Contato.class);
    }

}
