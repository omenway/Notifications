package Gateways;

public class GatewayFactory {
    private static GatewayFactory ins;
    private GatewayFactory(){};
    public static GatewayFactory getins() {
        if (ins == null) {
            return new GatewayFactory();
        } else {
            return ins;
        }
    }
        public Gateway getGatewaytype(String type){
            if(type=="Email"){
                return new EmailGateway();
            }
            else if (type=="SMS"){
                return new SMSGateway();
            }
            return null;
        }
    }

