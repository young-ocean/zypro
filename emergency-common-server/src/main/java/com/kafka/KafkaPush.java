package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author LI.HU
 * @date 2019/1/21   17:28
 * <p>Description:
 * Kafka消息推送
 * </p>
 */
@Component
@RestController
public class KafkaPush {
    private static final Logger logger = LoggerFactory.getLogger(KafkaPush.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;
    private static KafkaTemplate template;

    @PostConstruct
    private void init() {
        template = kafkaTemplate;
    }

    private static String producerTopic;

    @Value("${spring.kafka.producer.topic}")
    private void setTopic(String topic) {
        producerTopic = topic;
    }

    /**
     * 测试kafka
     * @return
     */
    @RequestMapping(value = "/sendMsg", method = RequestMethod.GET)
    public void sendKafka() {
        String msg = "{\"topics\":\"weatherTopic\",\"source\":\"jt\",\"command\":{\"module\":\"weatherSupport\",\"event\":\"weather\",\"data\":[{\"key\":\"暴雪\",\"list\":[{\"id\":69,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":36,\"pubTime\":1515231000000,\"pubUnit\":\"安徽省气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":62,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":64,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":102,\"pubTime\":1515047820000,\"pubUnit\":\"怀远县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":112,\"pubTime\":1515055800000,\"pubUnit\":\"泗县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":35,\"pubTime\":1515231000000,\"pubUnit\":\"安徽省气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":34,\"pubTime\":1515231000000,\"pubUnit\":\"安徽省气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":67,\"pubTime\":1515067800000,\"pubUnit\":\"寿县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":32,\"pubTime\":1515058800000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":49,\"pubTime\":1515059400000,\"pubUnit\":\"淮南市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":52,\"pubTime\":1515061800000,\"pubUnit\":\"灵璧县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":56,\"pubTime\":1515062400000,\"pubUnit\":\"巢湖市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":91,\"pubTime\":1515065400000,\"pubUnit\":\"六安市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":92,\"pubTime\":1515065400000,\"pubUnit\":\"金寨县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":89,\"pubTime\":1515066000000,\"pubUnit\":\"霍邱县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":63,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":24,\"pubTime\":1514984400000,\"pubUnit\":\"舒城县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":113,\"pubTime\":1515049800000,\"pubUnit\":\"太和县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":52,\"pubTime\":1515051000000,\"pubUnit\":\"阜阳市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":18,\"pubTime\":1515052800000,\"pubUnit\":\"无为县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":78,\"pubTime\":1515054000000,\"pubUnit\":\"五河县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":98,\"pubTime\":1515047820000,\"pubUnit\":\"怀远县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":108,\"pubTime\":1515055800000,\"pubUnit\":\"泗县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":125,\"pubTime\":1515028800000,\"pubUnit\":\"霍山县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":139,\"pubTime\":1515031200000,\"pubUnit\":\"固镇县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":152,\"pubTime\":1515031200000,\"pubUnit\":\"舒城县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":76,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":33,\"pubTime\":1515277200000,\"pubUnit\":\"泗县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":91,\"pubTime\":1515071400000,\"pubUnit\":\"舒城县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":74,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":109,\"pubTime\":1515024600000,\"pubUnit\":\"颍上县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":87,\"pubTime\":1515025200000,\"pubUnit\":\"明光市气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"红色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急和抢险工作；2.必要时停课、停业（除特殊行业外）；3.必要时飞机暂停起降，火车暂停运行，高速公路暂时封闭；4.做好牧区等救灾救济工作。\"},{\"id\":47,\"pubTime\":1515025320000,\"pubUnit\":\"怀远县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":67,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":121,\"pubTime\":1515076200000,\"pubUnit\":\"蚌埠市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":38,\"pubTime\":1515277200000,\"pubUnit\":\"泗县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":95,\"pubTime\":1515071400000,\"pubUnit\":\"舒城县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":27,\"pubTime\":1515074400000,\"pubUnit\":\"霍山县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":30,\"pubTime\":1515075600000,\"pubUnit\":\"五河县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":88,\"pubTime\":1515065400000,\"pubUnit\":\"金寨县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":86,\"pubTime\":1515066000000,\"pubUnit\":\"霍邱县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":78,\"pubTime\":1514985600000,\"pubUnit\":\"肥西县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":139,\"pubTime\":1515014400000,\"pubUnit\":\"濉溪县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":141,\"pubTime\":1515014400000,\"pubUnit\":\"寿县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":156,\"pubTime\":1515031200000,\"pubUnit\":\"舒城县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":102,\"pubTime\":1515024600000,\"pubUnit\":\"涡阳县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":39,\"pubTime\":1515000000000,\"pubUnit\":\"亳州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":132,\"pubTime\":1515003000000,\"pubUnit\":\"固镇县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":75,\"pubTime\":1515007200000,\"pubUnit\":\"六安市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":76,\"pubTime\":1515009600000,\"pubUnit\":\"淮南市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"红色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急和抢险工作；2.必要时停课、停业（除特殊行业外）；3.必要时飞机暂停起降，火车暂停运行，高速公路暂时封闭；4.做好牧区等救灾救济工作。\"},{\"id\":133,\"pubTime\":1515011400000,\"pubUnit\":\"利辛县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":32,\"pubTime\":1515012000000,\"pubUnit\":\"五河县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":97,\"pubTime\":1515013200000,\"pubUnit\":\"天长市气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"红色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急和抢险工作；2.必要时停课、停业（除特殊行业外）；3.必要时飞机暂停起降，火车暂停运行，高速公路暂时封闭；4.做好牧区等救灾救济工作。\"},{\"id\":100,\"pubTime\":1515013800000,\"pubUnit\":\"金寨县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":101,\"pubTime\":1515013800000,\"pubUnit\":\"泗县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":102,\"pubTime\":1515013800000,\"pubUnit\":\"界首市气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":70,\"pubTime\":1515261600000,\"pubUnit\":\"宿州市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":129,\"pubTime\":1515028200000,\"pubUnit\":\"合肥市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":133,\"pubTime\":1515031200000,\"pubUnit\":\"固镇县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":83,\"pubTime\":1515047400000,\"pubUnit\":\"金寨县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"红色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急和抢险工作；2.必要时停课、停业（除特殊行业外）；3.必要时飞机暂停起降，火车暂停运行，高速公路暂时封闭；4.做好牧区等救灾救济工作。\"},{\"id\":121,\"pubTime\":1515047820000,\"pubUnit\":\"怀远县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":81,\"pubTime\":1515048000000,\"pubUnit\":\"安徽省气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":82,\"pubTime\":1515048000000,\"pubUnit\":\"阜南县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":119,\"pubTime\":1515048000000,\"pubUnit\":\"六安市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"红色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急和抢险工作；2.必要时停课、停业（除特殊行业外）；3.必要时飞机暂停起降，火车暂停运行，高速公路暂时封闭；4.做好牧区等救灾救济工作。\"},{\"id\":117,\"pubTime\":1515076200000,\"pubUnit\":\"蚌埠市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":66,\"pubTime\":1515041400000,\"pubUnit\":\"庐江县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":67,\"pubTime\":1515041400000,\"pubUnit\":\"利辛县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":34,\"pubTime\":1515017400000,\"pubUnit\":\"蚌埠市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":89,\"pubTime\":1515018000000,\"pubUnit\":\"蒙城县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":88,\"pubTime\":1515018600000,\"pubUnit\":\"当涂县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":135,\"pubTime\":1515028800000,\"pubUnit\":\"霍山县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":42,\"pubTime\":1515277200000,\"pubUnit\":\"泗县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"蓝色\",\"action\":\"过期\",\"message\":\"1.政府及有关部门按照职责做好防雪灾和防冻害准备工作；2.交通、铁路、电力、通信等部门应当进行道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要储备饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":49,\"pubTime\":1515027000000,\"pubUnit\":\"和县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":56,\"pubTime\":1515029400000,\"pubUnit\":\"临泉县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":110,\"pubTime\":1515048000000,\"pubUnit\":\"马鞍山市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":108,\"pubTime\":1515048600000,\"pubUnit\":\"和县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":32,\"pubTime\":1515049200000,\"pubUnit\":\"霍邱县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"红色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急和抢险工作；2.必要时停课、停业（除特殊行业外）；3.必要时飞机暂停起降，火车暂停运行，高速公路暂时封闭；4.做好牧区等救灾救济工作。\"},{\"id\":114,\"pubTime\":1515049200000,\"pubUnit\":\"含山县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":112,\"pubTime\":1515049800000,\"pubUnit\":\"临泉县气象局\",\"alertType\":\"暴雪\",\"alertLevel\":\"橙色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责做好防雪灾和防冻害的应急工作；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.减少不必要的户外活动；4.加固棚架等易被雪压的临时搭建物，将户外牲畜赶入棚圈喂养。\"},{\"id\":32,\"pubTime\":1515015000000,\"pubUnit\":\"巢湖市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"},{\"id\":117,\"pubTime\":1515017400000,\"pubUnit\":\"淮北市气象台\",\"alertType\":\"暴雪\",\"alertLevel\":\"黄色\",\"action\":\"过期\",\"message\":\"1.政府及相关部门按照职责落实防雪灾和防冻害措施；2.交通、铁路、电力、通信等部门应当加强道路、铁路、线路巡查维护，做好道路清扫和积雪融化工作；3.行人注意防寒防滑，驾驶人员小心驾驶，车辆应当采取防滑措施；4.农牧区和种养殖业要备足饲料，做好防雪灾和防冻害准备；5.加固棚架等易被雪压的临时搭建物。\"}]}]}}";
        kafkaTemplate.send(producerTopic, msg);
    }


}
