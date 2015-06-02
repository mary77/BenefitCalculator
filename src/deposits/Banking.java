package deposits;

import exception.WrongDataException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class Banking {
    public static void main(String[] args) {

        ArrayList<Deposit> deposits = new ArrayList<Deposit>();
        try {
            File fXmlFile = new File("src/deposits.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("deposit");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    try {
                        DepositValidator.checkType(eElement.getElementsByTagName("depositType").item(0).getTextContent());
                        DepositValidator.checkBalance(new BigDecimal(eElement.getElementsByTagName("depositBalance").item(0).getTextContent()));
                        DepositValidator.checkDays(Integer.parseInt(eElement.getElementsByTagName("durationInDays").item(0).getTextContent()));
                        String className = "deposits." + eElement.getElementsByTagName("depositType").item(0).getTextContent() + "Deposit";
                        DepositType depositTypeInstance = (DepositType) Class.forName(className).newInstance();
                        Deposit deposit = new Deposit() ;
                        deposit.setCustomerNumber(Integer.parseInt(eElement.getElementsByTagName("customerNumber").item(0).getTextContent()));
                        deposit.setDepositBalance(new BigDecimal(eElement.getElementsByTagName("depositBalance").item(0).getTextContent()));
                        deposit.setDurationInDays(Integer.parseInt(eElement.getElementsByTagName("durationInDays").item(0).getTextContent()));
                        deposit.setPayedInterest(deposit.calculateInterest(deposit.getDepositBalance(), deposit.getDurationInDays(),depositTypeInstance));
                        deposit.setDepositType(depositTypeInstance);
                        deposits.add(deposit);
                    } catch (WrongDataException e) {
                        System.out.println("UnExpected Error " + e.getMessage());
                    }
                }
            }
            Collections.sort(deposits);
            for (Deposit deposit : deposits) {
                System.out.println(deposit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
