package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Gasto;
import br.com.fintech.dao.GastoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.Conexao;

public class OracleGastoDAO  implements GastoDAO{

	private Connection conexao;

	
	@Override
	public void cadastrar(Gasto gasto) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = Conexao.getInstance().getConnection();
			String sql = "INSERT INTO T_GASTO (CD_GASTO, CD_USUARIO, NM_GASTO, VLR_GASTO, DS_GASTO) VALUES (SEQ_GAS.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, gasto.getCodigoUsuario());
			stmt.setString(2, gasto.getNome());
			stmt.setDouble(3, gasto.getValor());
			stmt.setString(4, gasto.getDescricao());
			
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar gasto.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Gasto gasto) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = Conexao.getInstance().getConnection();
			String sql = "UPDATE T_GASTO SET NM_GASTO = ?, VLR_GASTO = ?, DS_GASTO = ? WHERE CD_GASTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, gasto.getNome());
			stmt.setDouble(2, gasto.getValor());
			stmt.setString(3, gasto.getDescricao());
			stmt.setInt(4, gasto.getCodigoGasto());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar gasto");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
		
	@Override
	public void remover(int cd) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = Conexao.getInstance().getConnection();
			String sql = "DELETE FROM T_GASTO WHERE CD_GASTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover gasto.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}

	@Override
	public Gasto buscar(int cd) {
		Gasto gasto = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = Conexao.getInstance().getConnection();
			String sql = "SELECT * FROM T_GASTO WHERE CD_GASTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigoGas = rs.getInt("CD_GASTO");
				int codigoUsu = rs.getInt("CD_USUARIO");
				String nome = rs.getString("NM_GASTO");
				double valor = rs.getDouble("VLR_GASTO");
				String descricao = rs.getString("DS_GASTO");
				
				gasto = new Gasto(codigoGas, codigoUsu, nome, valor, descricao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gasto;
	}

	@Override
	public List<Gasto> listar() {
		List<Gasto> lista = new ArrayList<Gasto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = Conexao.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_GASTO");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int codigoGas = rs.getInt("CD_GASTO");
				int codigoUsu = rs.getInt("CD_USUARIO");
				String nome = rs.getString("NM_GASTO");
				double valor = rs.getDouble("VLR_GASTO");
				String descricao = rs.getString("DS_GASTO");
				
				Gasto gasto = new Gasto(codigoGas, codigoUsu, nome, valor, descricao);
				lista.add(gasto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}
