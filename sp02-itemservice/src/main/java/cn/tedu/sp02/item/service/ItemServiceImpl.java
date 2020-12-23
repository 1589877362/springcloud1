package cn.tedu.sp02.item.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    // 根据订单id获取商品列表
    @Override
    public List<Item> getItems(String orderId) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1,"商品1",1));
        list.add(new Item(2,"商品2",4));
        list.add(new Item(3,"商品3",2));
        list.add(new Item(4,"商品4",5));
        list.add(new Item(5,"商品5",1));
        return list;
    }
    // 减少商品的库存
    @Override
    public void decreaseNumber(List<Item> items) {
        for (Item item: items) {
            log.info("减少商品库存： "+item);
        }
    }

}
