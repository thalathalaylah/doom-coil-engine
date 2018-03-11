package infra.bitflyer

import java.security.InvalidParameterException

import domain.client.single.{ProductCode, Side, TimeInForce}
import domain.client.single.ProductCode.BtcJpyFx
import domain.client.single.Side.{Buy, Sell}
import domain.client.single.TimeInForce.{FOK, GTC, IOC}

object BitFlyerParameterConverter {
  def productCode(productCode: ProductCode): String =
    productCode match {
      case BtcJpyFx => "FX_BTC_JPY"
      case _ => throw new InvalidParameterException("invalid product code for bitflyer")
    }

  def side(side: Side): String =
    side match {
      case Buy => "BUY"
      case Sell => "SELL"
    }

  def timeInForce(timeInForce: TimeInForce): String =
    timeInForce match {
      case GTC => "GTC"
      case IOC => "IOC"
      case FOK => "FOK"
      case _ => throw new InvalidParameterException("invalid time in force for bitflyer")
    }
}
