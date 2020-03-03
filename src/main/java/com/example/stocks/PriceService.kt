package com.example.stocks

import com.example.stocks.model.StockPrice
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ThreadLocalRandom

@Service
class PriceService {
    private val prices = ConcurrentHashMap<String, Flux<StockPrice>>()

    fun getPrices(symbol: String): Flux<StockPrice> {
        return prices.computeIfAbsent(symbol) {
            Flux.interval(Duration.ofSeconds(1))
                    .map { StockPrice(symbol, generateRandomPrice(), LocalDateTime.now()) }
                    .share()
        }
    }

    private fun generateRandomPrice(): Double {
        return ThreadLocalRandom.current().nextDouble(50.0)
    }

}

