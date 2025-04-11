package services.impl;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.VentaMapper;
import models.Venta;
import services.VentaService;

public class VentaServiceImpl implements VentaService {

	@Override
	public Venta obtenerVentaPorCodigoInterno(String codigoInterno) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			VentaMapper ventaMapper = session.getMapper(VentaMapper.class);
			return ventaMapper.obtenerVentaPorCodigoInterno(codigoInterno);
		} catch (Exception e) {
			System.out.println("obtenerVentaPorCodigoInterno::" + e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Venta insertarVenta(Venta venta) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			VentaMapper ventaMapper = session.getMapper(VentaMapper.class);
			ventaMapper.insertarVenta(venta);
			session.commit();
			return venta;
		} catch (Exception e) {
			System.out.println("insertarVenta::" + e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void actualizarVentaMontoTotal(Integer idVenta) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			VentaMapper ventaMapper = session.getMapper(VentaMapper.class);
			ventaMapper.actualizarVentaMontoTotal(idVenta);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertarVentaDetalle::"+e);
			e.printStackTrace();
		}
		
	}
}
