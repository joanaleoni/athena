package Model.DAO;

import Model.Database.Database;
import Model.Database.DatabaseFactory;
import Model.Domain.Professor;
//import Model.Domain.Disciplina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ProfessorDAO {
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();

    public Connection getConnection() {
        return connection;
    }

    public List<Professor> listar() {
        String sql = "SELECT * FROM professor";
        List<Professor> retorno = new ArrayList<>();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Professor professor = new Professor();
                professor.setMatricula(resultado.getInt("matricula"));
                professor.setNome(resultado.getString("nome"));
                professor.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                professor.setRg(resultado.getString("rg"));
                professor.setCpf(resultado.getString("cpf"));
                professor.setDataAdmissao(resultado.getDate("data_admissao").toLocalDate());
                professor.setFormacao(resultado.getString("formacao"));
                professor.setNivelTitulacao(resultado.getString("nivel_titulacao"));
                
                
                
              //  professor.setDisciplinas(getDisciplinas(professor));
                
                retorno.add(professor);
            }
        }  catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
        return retorno;
    }
    
//    public List<Disciplina> getDisciplinas(Professor professor){
//        String sql = "SELECT codigo, disciplina.nome as nome_disciplina, carga_horaria FROM disciplina " +
//                     "LEFT JOIN professor_ministra_disciplina ON disciplina_codigo=codigo " +
//                     "JOIN professor ON professor_matricula=? " +
//                     "GROUP BY codigo";
//        List<Disciplina> retorno = new ArrayList<>();
//        
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            ResultSet resultado = stmt.executeQuery();
//            while(resultado.next()){
//                Disciplina disciplina = new Disciplina();
//                disciplina.setCodigo(resultado.getString("codigo"));
//                disciplina.setNome(resultado.getString("nome"));
//                disciplina.setCargaHoraria(resultado.getInt("carga_horaria"));
//                
//                retorno.add(disciplina);
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        
//        return retorno;        
//    }
//    

    public boolean InsertProfessorBD(Professor professor) {
        String sql = "INSERT INTO professor(nome, data_nascimento, rg, cpf, data_admissao, formacao, nivel_titulacao) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setString(1, professor.getNome());
            stmt.setDate(2, Date.valueOf(professor.getDataNascimento()));
            stmt.setString(3, professor.getRg());
            stmt.setString(4, professor.getCpf());
            stmt.setDate(5, Date.valueOf(professor.getDataAdmissao()));
            stmt.setString(6, professor.getFormacao());
            stmt.setString(7, professor.getNivelTitulacao());
            
           
            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    
    public boolean DeleteProfessorBD(int matricula) {
        String sql = "DELETE FROM professor WHERE matricula=?";
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
    
    public boolean UpdateProfessorBD(Professor professor) {
        String sql = "UPDATE professor SET nome=?, data_nascimento=?, rg=?, cpf=?, data_admissao=?, formacao=?, nivel_titulacao=? WHERE matricula=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setDate(2, Date.valueOf(professor.getDataNascimento()));
            stmt.setString(3, professor.getRg());
            stmt.setString(4, professor.getCpf());
            stmt.setDate(5, Date.valueOf(professor.getDataAdmissao()));
            stmt.setString(6, professor.getFormacao());
            stmt.setString(7, professor.getNivelTitulacao());
 
            stmt.setInt(8, professor.getMatricula());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
        public Professor carregaProfessor(int matricula) {
        String sql = "SELECT * FROM professor WHERE matricula=?";
        Professor professor = new Professor();
        professor.setMatricula(matricula);

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, professor.getMatricula());
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                professor.setNome(resultado.getString("nome"));
                professor.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                professor.setRg(resultado.getString("rg"));
                professor.setCpf(resultado.getString("cpf"));
                professor.setDataAdmissao(resultado.getDate("data_admissao").toLocalDate());
                professor.setFormacao(resultado.getString("formacao"));
                professor.setNivelTitulacao(resultado.getString("nivel_formacao"));
                
             
            }
           

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return professor;
    }
   
}
