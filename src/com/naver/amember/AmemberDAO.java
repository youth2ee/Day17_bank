package com.naver.amember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naver.util.DBConnector;

public class AmemberDAO {
	
	public int memberJoin(AmemberDTO amemberDTO) throws Exception {
		Connection con =null;
		PreparedStatement st =null;
		int result = 0;
		
			con = DBConnector.getConnect();
			String sql = "insert into amember values (?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, amemberDTO.getId());
			st.setString(2, amemberDTO.getPw());
			st.setString(3, amemberDTO.getName());
			st.setString(4, amemberDTO.getPhone());
			st.setString(5, amemberDTO.getEmail());

			result = st.executeUpdate();
		
			

				st.close();
				con.close();

		
		return result;
	}//memberJoin
	
	public AmemberDTO memberLogin(AmemberDTO amemberDTO) {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		//AmemberDTO amemberDTO = null;
		
		try {
			con = DBConnector.getConnect();
			String sql = "select * from amember where id=? and pw=?";
			st = con.prepareStatement(sql);
			st.setString(1, amemberDTO.getId());
			st.setString(2, amemberDTO.getPw());
			
			rs = st.executeQuery();
			if(rs.next()) {
				//amemberDTO = new AmemberDTO();
				//amemberDTO.setId(rs.getString(1));
				//amemberDTO.setPw(rs.getString(2));
				amemberDTO.setName(rs.getString(3));
				amemberDTO.setPhone(rs.getString(4));
				amemberDTO.setEmail(rs.getString(5));
			} else {
				amemberDTO = null;
			}
			
			/*
			if(rs.next()) {
				새로 객체생성안하고 amemberDTO에 아이디랑 비번받아서 위에서 썼다면
				그걸 그냥 사용한다. 이 안에 들어온다면 로그인이 성공한 것이므로
				아이디, 패스워드 말고 나머지만 입력해준다. 그러나 리턴을 amemberDTO로
				받아서 로그인성공여부를 알고싶다면 지금상황은 아이디랑 패스워드는 값이 있으므로
				null값이 아니다. 따라서
			} else {
				여기서 amemberDTO = null;로 만들어서 리턴해주면
				로그인판별할 수 있다.
			}
			*/
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return amemberDTO;
	}//memberLogin
	
}
