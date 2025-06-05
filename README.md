## Arquitetura do Sistema

A arquitetura do BarberScheduling segue uma abordagem orientada a microsserviços, com comunicação assíncrona via Kafka e gerenciamento centralizado por um API Gateway.

```
                         [ Frontend / Mobile ]
                                   │
                                   ▼
                           [ API Gateway ]
                                   │
        ┌─────────────────────────┼──────────────────────────┐
        ▼                         ▼                          ▼
[ Client Service ]     [ Barbershop Service ]     [ Professional Service ]
        ▲                         ▲                          ▲
        └──────────────┬──────────┘                          │
                       ▼                                     │
              [ Schedule Service ] ───────────────┐          │
                       │                          ▼          ▼
                       └────────▶ [ Appointment Service ] ◀──┘
                                            │
                                         Kafka Topics
```
