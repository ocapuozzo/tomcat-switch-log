define host {
    use                     generic-switch
    host_name               ${switch.name}
    alias                   ${switch.fullName}
    address                 ${switch.ip}
    hostgroups              switches
<#if switch.parent != "" >
    parents                 ${switch.parent}
<#else>

</#if>


}

define service {
    use                     generic-service
    host_name               ${switch.name}
    service_description     PING
    check_command           check_ping!200.0,20%!600.0,60%
    check_interval          5
    retry_interval          1
}

