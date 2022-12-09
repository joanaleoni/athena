package Model.DAO;

import Model.Database.*;
import Model.Domain.Aluno;
import Model.Domain.Disciplina;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class AlunoDAO {
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    
    public Connection getConnection() {
        return connection;
    }

    public List<Aluno> listar() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> retorno = new ArrayList<>();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Aluno aluno = new Aluno();
                aluno.setMatricula(resultado.getInt("matricula"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                aluno.setRg(resultado.getString("rg"));
                aluno.setCpf(resultado.getString("cpf"));
                aluno.setCurso(resultado.getString("curso"));
                aluno.setFase(resultado.getInt("fase"));
                
                retorno.add(aluno);
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
        return retorno;
    }


    public boolean InsertAlunoBD(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome, data_nascimento, rg, cpf, curso, fase) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setDate(2, Date.valueOf(aluno.getDataNascimento()));
            stmt.setString(3, aluno.getRg());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getCurso());
            stmt.setInt(6, aluno.getFase());

            stmt.execute();
            stmt.close();
            
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

 
    public boolean DeletetAlunoBD(int matricula) {
        String sql = "DELETE FROM aluno WHERE matricula=?";           
            
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, matricula);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }
    }

    public boolean UpdateAlunoBD(Aluno aluno) {

        String sql = "UPDATE aluno SET nome=?, data_nascimento=?, rg=?, cpf=?, curso=?, fase=? WHERE matricula=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setDate(2, Date.valueOf(aluno.getDataNascimento()));
            stmt.setString(3, aluno.getRg());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getCurso());
            stmt.setInt(6, aluno.getFase());
            stmt.setInt(7, aluno.getMatricula());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public Aluno carregaAluno(int matricula) {       
        String sql = "SELECT * FROM aluno WHERE matricula=?";
        Aluno aluno = new Aluno();
        aluno.setMatricula(matricula);
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                aluno.setNome(resultado.getString("nome"));
                aluno.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                aluno.setRg(resultado.getString("rg"));
                aluno.setCpf(resultado.getString("cpf"));
                aluno.setCurso(resultado.getString("curso"));
                aluno.setFase(resultado.getInt("fase"));
            }
           

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return aluno;
    }
    
    public List<Disciplina> getDisciplinas(Aluno aluno){
        String sql = "SELECT codigo, disciplina.nome as nome_disciplina, carga_horaria FROM disciplina_has_aluno " +
                     "LEFT JOIN disciplina ON disciplina_codigo=codigo " +
                     "JOIN aluno ON aluno_matricula=? " +
                     "GROUP BY codigo";
        List<Disciplina> retorno = new ArrayList<>();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setCodigo(resultado.getString("codigo"));
                disciplina.setNome(resultado.getString("nome_disciplina"));
                disciplina.setCargaHoraria(resultado.getInt("carga_horaria"));
                
                retorno.add(disciplina);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return retorno;
    }
}
