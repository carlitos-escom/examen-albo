package com.albo.comics.scheduler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.albo.comics.service.MarvelService;
import io.quarkus.scheduler.Scheduled;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ConsultaBean {
    private static final Logger LOG = Logger.getLogger(ConsultaBean.class);

    @Inject
    MarvelService marvelService;

    @Scheduled(cron = "{cron.expr}")
    void cronJobWithExpressionInConfig() {
        LOG.info("Se lanza cron");
        marvelService.getComics();
    }
}
