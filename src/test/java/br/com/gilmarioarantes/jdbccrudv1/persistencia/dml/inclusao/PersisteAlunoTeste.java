package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraListaAlunos;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class PersisteAlunoTeste {

    Logger logger = Logger.getLogger(PersisteAlunoTeste.class.getName());

    @Test
    public void persisteAlunoTest(){

        logger.info("Executando o mÃ©todo persisteAlunoTest() da classe: " + this.getClass().getSimpleName());

        List<Aluno> alunos = GeraListaAlunos.geraLista();

        boolean result = false;

        try{
            for(Aluno aluno : alunos){
                result = new PersisteAluno().persisteAluno(aluno);
            }
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void persisteAlunoTest1(){
        logger.info("Executando o método persisteAlunoTest() da classe: " + this.getClass().getSimpleName());
        Aluno aluno = new Aluno();
        aluno.setId(1000L);
        aluno.setSexo("M");
        aluno.setMatricula("12345");
        aluno.setNome("Fabio Henrique");
        aluno.setDataNascimento(new Timestamp(Calendar.getInstance().getTime().getTime()));
        boolean result = false;
        try {
            result = new PersisteAluno().persisteAluno(aluno);
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }

}
