/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.teste;

import cadastro.ejb.PessoaRemote;
import cadastro.modelo.Pessoa;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author gcamargo
 */
public class Cadastrar {

    public static void main(String[] args) throws NamingException, ParseException, Exception {

        //inserirNovaPessoa();

        //atualizarPessoa();

        removerPessoa();

    }

    private static void inserirNovaPessoa() throws NamingException, ParseException, Exception{
        InitialContext ctx = new InitialContext();
        PessoaRemote ejb = (PessoaRemote) ctx.lookup("cadastro.ejb.PessoaRemote");
        Pessoa p = new Pessoa();
        p.setNome("Guilherme");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        p.setNascimento(df.parse("21/12/1988"));
        p.setEmail("btguilherme@msn.com");
        p = ejb.inserir(p);
        System.out.println("Id inserido: " + p.getId());
    }

    private static void atualizarPessoa() throws NamingException, ParseException, Exception {
        InitialContext ctx = new InitialContext();
        PessoaRemote ejb = (PessoaRemote) ctx.lookup("cadastro.ejb.PessoaRemote");
        Pessoa p = ejb.consultarPorId(1L);
        p.setNome("Guilherme Camargo");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        p.setNascimento(df.parse("21/12/1988"));
        p.setEmail("btguilherme@msn.com");
        p = ejb.inserir(p);
        System.out.println("Id inserido: " + p.getId());
        System.out.println("Novo nome: " + p.getNome());
    }

    private static void removerPessoa() throws NamingException {
        InitialContext ctx = new InitialContext();
        PessoaRemote ejb = (PessoaRemote) ctx.lookup("cadastro.ejb.PessoaRemote");
        ejb.remover(1L);
        System.out.println("Fim!");
    }

}
