package com.imooc.cart.servlet;

import com.imooc.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品（课程）控制器，上一页下一页等数据操作
 */
public class ProductServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);不需要执行父类的方法

        //啊啊啊啊~浪费了半天时间，找了这天久，看了那么多次，都没看到路径写错了，写少一个“/“
        //req.getRequestDispatcher("WEB-INF/views/biz/list.jsp").forward(req,resp);
        //拷贝：
       //req.setAttribute("products", LocalCache.getProducts());
       //req.getRequestDispatcher("/WEB-INF/views/biz/list.jsp").forward(req, resp);

        String name = req.getParameter("title");

        String pageStr = req.getParameter("page");
        int page = 1;
        if (null != pageStr && !"".equals(pageStr)) {
            page = Integer.parseInt(pageStr);
        }

        int totalProducts = LocalCache.getProductsCount(name);
        int totalPage = totalProducts % 12 > 0 ? totalProducts / 12 + 1 : totalProducts / 12;

        req.setAttribute("curPage", page);
        req.setAttribute("prePage", page > 1 ? page - 1 : 1);
        req.setAttribute("nextPage", totalPage > page ? page + 1 : totalPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("title", name);


        req.setAttribute("products", LocalCache.getProducts(page, 12, name));
        req.getRequestDispatcher("/WEB-INF/views/biz/list.jsp").forward(req, resp);

    }

    @Override
    public void init() throws ServletException {
         super.init();

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
