### Ribbon Client
This application uses Ribbon Client to load balance http calls to order service.

Below are the load balancing rules -<br> 
       1.  new RoundRobinRule();<br>
       2.  new WeightedResponseTimeRule();<br>
       3.  new BestAvailableRule();<br>
       4.  new AvailabilityFilteringRule();<br>
       
account-service:<br/>
 ribbon: <br/>
   NFLoadBalancerPingClassName: com.netflix.loadbalancer.PingUrl<br/>
   NFLoadBalancerRuleClassName: com.netflix.loadbalancer.WeightedResponseTimeRule<br/>
   
https://github.com/Netflix/ribbon/wiki/Working-with-load-balancers

####Hytrix Configuration List

https://github.com/Netflix/Hystrix/wiki/Configuration

####Hystrix Dashboard

1. Enabled using @EnableHystrixDashboard
2. Dashboard - http://localhost:7001/hystrix
