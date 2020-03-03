package com.example.stocks.controllers

import com.example.stocks.PriceService
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class RSocketController(val priceService: PriceService) {
    @MessageMapping("stockPrices")
    fun pricesFor(symbol: String) = priceService.getPrices(symbol)
}