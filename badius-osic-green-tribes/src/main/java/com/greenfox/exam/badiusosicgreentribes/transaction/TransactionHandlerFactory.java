package com.greenfox.exam.badiusosicgreentribes.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.ProductionRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.UpgradeRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.ProductionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.UpgradeHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.TransactionHandlerRegistry;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionHandlerFactory {

    private MovementRepository movementRepository; // FIXME itt nincs szükség repository-ra.
    private ProductionRepository productionRepository; // FIXME itt nincs szükség repository-ra.
    private UpgradeRepository upgradeRepository; // FIXME itt nincs szükség repository-ra.
    private BeanFactory beanFactory;
    private TransactionHandlerRegistry handlerRegistry;

    @Autowired //FIXME nem kell több függőség mint a BeanFactory és TransactionHandlerRegistry
    public TransactionHandlerFactory(BeanFactory beanFactory, TransactionHandlerRegistry handlerRegistry, MovementRepository movementRepository,
                                     ProductionRepository productionRepository,
                                     UpgradeRepository upgradeRepository) {
        this.beanFactory = beanFactory;
        this.handlerRegistry = handlerRegistry;
        this.movementRepository = movementRepository;
        this.productionRepository = productionRepository;
        this.upgradeRepository = upgradeRepository;
    }


    //FIXME Nem ez a helyes működés. Ez a metódus a paraméterként kapott TransactionType-ot kell átforgassa Class<?> -ra (a handlerRegistry-vel),
    // amit utána paraméterként felhasználhat a beanFactory.getBean()-hez. Amit a beanfactory kiad azzal kell itt visszatérni
    public TransactionHandler<? extends Transaction> getHandler(TransactionType type){
        switch (type) {
            case MOVEMENT:
                return new MovementHandler(movementRepository);
            case PRODUCTION:
                return new ProductionHandler(productionRepository);
            case UPGRADE:
                return new UpgradeHandler(upgradeRepository);
            default:
                throw new IllegalArgumentException("Invalid Transaction Type");
        }
    }
}
