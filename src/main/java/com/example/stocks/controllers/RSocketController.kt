package com.example.stocks.controllers

import com.example.stocks.PriceService
import com.example.stocks.model.StockPrice
import org.springframework.messaging.handler.annotation.MessageMapping
import reactor.core.publisher.Flux

class RSocketController(val priceService: PriceService) {
    @MessageMapping("stockPrices")
    fun pricesFor(symbol: String) = priceService.getPrices(symbol)
}