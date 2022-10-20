package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.bucket.BucketName;
import br.com.sancode.sancodesiriusapi.exception.NotFoundException;
import br.com.sancode.sancodesiriusapi.model.MovimentoVistoriaVeiculo;
import br.com.sancode.sancodesiriusapi.repository.MovimentoVistoriaVeiculoRepository;
import br.com.sancode.sancodesiriusapi.util.ISancodeCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class MovimentoVistoriaVeiculoServiceImpl implements ISancodeCRUDService<MovimentoVistoriaVeiculo> {

    private final MovimentoVistoriaVeiculoRepository movimentoVistoriaVeiculoRepository;
    private final FileStore fileStore;

    @Autowired
    public MovimentoVistoriaVeiculoServiceImpl(MovimentoVistoriaVeiculoRepository movimentoVistoriaVeiculoRepository, FileStore fileStore) {
        this.movimentoVistoriaVeiculoRepository = movimentoVistoriaVeiculoRepository;
        this.fileStore = fileStore;
    }

    @Override
    public List<MovimentoVistoriaVeiculo> findAll() {
        return movimentoVistoriaVeiculoRepository.findAll();
    }

    @Override
    public MovimentoVistoriaVeiculo save(MovimentoVistoriaVeiculo entity) {
        return movimentoVistoriaVeiculoRepository.save(entity);
    }

    @Override
    public MovimentoVistoriaVeiculo findById(Long id) {
        Optional<MovimentoVistoriaVeiculo> movimentoVistoriaVeiculo = movimentoVistoriaVeiculoRepository.findById(id);
        if(!movimentoVistoriaVeiculo.isPresent())
            throw new NotFoundException("Vistoria Veículo não encontrado! Id: " + id + MovimentoVistoriaVeiculo.class.getName());
        return movimentoVistoriaVeiculo.get();
    }

    @Override
    public MovimentoVistoriaVeiculo findByDescricao(String descricao) {
        return null;
    }

    @Override
    public void delete(MovimentoVistoriaVeiculo entity) {
        movimentoVistoriaVeiculoRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        movimentoVistoriaVeiculoRepository.deleteById(id);
    }

    public void uploadImageVeiculoFrontal(Long id, MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Não é possivel enviar uma imagem vazia [ " +file.getSize() + " ]" );
        }

        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("O arquivo precisa ser uma imagem");
        }

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "fotos");
        String fileName = String.format("vistoria/%s/%s", String.format("%08d", id), file.getOriginalFilename());
        String fieldFileName = file.getOriginalFilename();
        try {
            fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
            Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
            mvv.get().setImageLinkVeiculoFrontal(fieldFileName);
            movimentoVistoriaVeiculoRepository.save(mvv.get());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void uploadImageVeiculoTraseira(Long id, MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Não é possivel enviar uma imagem vazia [ " +file.getSize() + " ]" );
        }

        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("O arquivo precisa ser uma imagem");
        }

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "fotos");
        String fileName = String.format("vistoria/%s/%s", String.format("%08d", id), file.getOriginalFilename());
        String fieldFileName = file.getOriginalFilename();
        try {
            fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
            Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
            mvv.get().setImageLinkVeiculoTraseira(fieldFileName);
            movimentoVistoriaVeiculoRepository.save(mvv.get());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void uploadImageVeiculoLateralEsquerdo(Long id, MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Não é possivel enviar uma imagem vazia [ " +file.getSize() + " ]" );
        }

        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("O arquivo precisa ser uma imagem");
        }

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "fotos");
        String fileName = String.format("vistoria/%s/%s", String.format("%08d", id), file.getOriginalFilename());
        String fieldFileName = file.getOriginalFilename();
        try {
            fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
            Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
            mvv.get().setImageLinkVeiculoLateralEsquerdo(fieldFileName);
            movimentoVistoriaVeiculoRepository.save(mvv.get());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void uploadImageVeiculoLateralDireito(Long id, MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Não é possivel enviar uma imagem vazia [ " +file.getSize() + " ]" );
        }

        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("O arquivo precisa ser uma imagem");
        }

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "fotos");
        String fileName = String.format("vistoria/%s/%s", String.format("%08d", id), file.getOriginalFilename());
        String fieldFileName = file.getOriginalFilename();
        try {
            fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
            Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
            mvv.get().setImageLinkVeiculoLaterialDireita(fieldFileName);
            movimentoVistoriaVeiculoRepository.save(mvv.get());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public byte[] downloadImageVeiculoFrontal(Long id) {
        Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
        String path = String.format("%s/fotos/vistoria/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                String.format("%08d", id));
        String imageLink = mvv.get().getImageLinkVeiculoFrontal();
        return fileStore.download(path, imageLink);
    }
    public byte[] downloadImageVeiculoTraseira(Long id) {
        Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
        String path = String.format("%s/fotos/vistoria/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                String.format("%08d", id));
        String imageLink = mvv.get().getImageLinkVeiculoTraseira();
        return fileStore.download(path, imageLink);
    }
    public byte[] downloadImageVeiculoLateralEsquerdo(Long id) {
        Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
        String path = String.format("%s/fotos/vistoria/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                String.format("%08d", id));
        String imageLink = mvv.get().getImageLinkVeiculoLateralEsquerdo();
        return fileStore.download(path, imageLink);
    }
    public byte[] downloadImageVeiculoLateralDireito(Long id) {
        Optional<MovimentoVistoriaVeiculo> mvv = movimentoVistoriaVeiculoRepository.findById(id);
        String path = String.format("%s/fotos/vistoria/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                String.format("%08d", id));
        String imageLink = mvv.get().getImageLinkVeiculoLaterialDireita();
        return fileStore.download(path, imageLink);
    }
}