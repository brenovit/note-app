package br.com.friends.noteapp.job.notification;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.model.IJobNew;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Job3 implements IJobNew{	
	
	@Getter
	private boolean isAlive;
	@Getter
	private String nextExecution;
	
	@Autowired
	private TaskScheduler taskScheduler;

	@Getter
	private ScheduledFuture<?> scheduledFuture;
	
	@Override
	public void run() {
		log.info(getName());		
	}	
	
	@Override
	public void start() {
		isAlive = true;
		log.info("Start: "+getName()+" | "+new Date().toString());
		
		int minuto = 5;
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.add(Calendar.MINUTE, minuto);
		Date dataExecucao = getProximaExecucao(dataAtual.getTime(),
				dataAtual.get(Calendar.HOUR_OF_DAY), dataAtual.get(Calendar.MINUTE));
		
		scheduledFuture = taskScheduler.schedule(this, dataExecucao);
		nextExecution = dataExecucao.toString();
	}
	
	@Override
	public void stop() {
		log.info("Stop: "+getName()+" | "+new Date().toString());
		isAlive = false;
		scheduledFuture.cancel(true);
		nextExecution = "";
	}

	public static Date getProximaExecucao(Date data, int hora, int minuto) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minuto);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
	
}
